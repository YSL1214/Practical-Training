package dao;

import model.Old;
import model.age;

import java.util.List;

public interface OldMapper {
    List<Old> selectOldInfo();

    Old getSelectIDOld(int id);

    void addold(Old old);

    void deleteSelectIdOld(int id);

    void updateImg(Old old);

    void updateold(Old old);

    List<age> getOldNum();
}
