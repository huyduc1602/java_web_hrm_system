package tsg.net.vn.hrmweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.repository.PositionRepositoty;
import tsg.net.vn.hrmweb.service.PositionService;


@Controller
public class PositionController {
	@Autowired
	private PositionService positionService;
	@Autowired
	private PositionRepositoty positionRepositoty;
	
	public PositionController(PositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("/positions")
	public String getAllPosition(Model model) {
		List<Position> PositionList = positionService.getAllPosition();
		model.addAttribute(PositionList);
		return "positions";
	}

	@RequestMapping(path = {"/positions/add","/positions/update","/positions/update/{id}" ,"/positions/view/{id}"})
    public String addOrViewPosition(Model model, @PathVariable("id") Optional<Long> id) 
                            throws Exception {
        if (id.isPresent()) {
        	Position entity = positionService.getpositionById(id.get());
            model.addAttribute("position", entity);
        } else {
            model.addAttribute("position", new Position());
        }
        return "position/position-add-edit";
    }

	@RequestMapping(path = "/createPosition",method= RequestMethod.POST)
	public String createOrUpdatPosition(Position position) {
		positionService.createOrUpdatePosition(position);
		return "redirect:/positions";	
	}
	@GetMapping("/positions/delete/{positionId}")
	public String deletePosition(@PathVariable("positionId") Long deId, Model model) {
		Position position = positionRepositoty.findById(deId)
				.orElseThrow(() -> new IllegalArgumentException("Mã phòng ban không hợp lệ: " + deId));
		positionService.deletepositionById(deId);
		model.addAttribute("positionList", positionService.getAllPosition());
		return "redirect:/positions";
	}
}
