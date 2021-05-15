package tsg.net.vn.hrmweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsg.net.vn.hrmweb.model.Position;
import tsg.net.vn.hrmweb.repository.PositionRepositoty;

@Service
public class PositionService {
	@Autowired
	private PositionRepositoty positionRepository;
	
	public List<Position> getAllPosition() {
		return positionRepository.findAll();
	}

	public Position updatePositionById(Long posId, String posName,String posCode,String posDesc) {
		Optional<Position> posOption = positionRepository.findById(posId);
		if (posOption.isPresent()) {
			Position pos = posOption.get();
			pos.setPosName(posName);
			pos.setPosCode(posCode);
			pos.setPosDesc(posDesc);
			positionRepository.save(pos);
			return pos;
		}
		return null;
	}
	public Position createOrUpdatePosition(Position entity) 
    {
        if(entity.getPosId() == null) 
        {
            entity = positionRepository.save(entity);
             
            return entity;
        } 
        else
        {
            Optional<Position> position = positionRepository.findById(entity.getPosId());
             
            if(position.isPresent()) 
            {
            	Position newEntity = position.get();
            	newEntity.setPosName(entity.getPosName());
                newEntity.setPosCode(entity.getPosCode());
                newEntity.setPosDesc(entity.getPosDesc());
                
                newEntity = positionRepository.save(newEntity);
                 
                return newEntity;
            } else {
                entity = positionRepository.save(entity);
                 
                return entity;
            }
        }
    }
	public Position getpositionById(Long id) throws Exception{
        Optional<Position> position = positionRepository.findById(id);
         
        if(position.isPresent()) {
            return position.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
	public Boolean deletepositionById(Long deId) {
		Optional<Position> deOption = positionRepository.findById(deId);
		if (deOption.isPresent()) {
			positionRepository.delete(deOption.get());
			return true;
		}
		return false;
	}
}
