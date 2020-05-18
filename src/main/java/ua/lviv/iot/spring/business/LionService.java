package ua.lviv.iot.spring.business;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.dataaccess.LionRepository;
import ua.lviv.iot.spring.model.Lion;

@Service
public class LionService {
  @Autowired
  private LionRepository lionRepository;

  public Lion createLion(Lion lion) {
    return lionRepository.save(lion);
  }

  public Lion getLion(Integer lionId) {
    return lionRepository.findById(lionId).orElse(null);
  }

  public List<Lion> getAllLions() {
    return lionRepository.findAll();
  }

  public Lion updateLion(Integer lionId, Lion lion) {
    Lion oldOption = null;
    Lion temporaryOption = lionRepository.findById(lionId).orElse(null);
    if (temporaryOption != null) {
      oldOption = new Lion();
      BeanUtils.copyProperties(temporaryOption, oldOption);
      lionRepository.save(lion);
    }
    return oldOption;
  }

  public Lion deleteLion(Integer lionId) {
    Lion oldOption = lionRepository.findById(lionId).orElse(null);
    if (oldOption != null) {
      lionRepository.deleteById(lionId);
    }
    return oldOption;
  }

}
