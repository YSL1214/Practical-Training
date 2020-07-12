package service;

import model.Old;
import model.age;

import java.util.List;

public interface OldService {
    List<Old> getOldInfo();

    Old getSelectOldInfo(int id);

    void addOldperson(Old old);

    void deleteSelectIdOld(int id);

    void updateAddressOfPic(Integer valueOf, String path);

    void updateOldperson(Old old);

    List<age> getOldNum();
}
