package tridm.StudentManagement.services;

import java.util.List;

import tridm.StudentManagement.models.MonHoc;

public interface MonHocService {
    List<MonHoc> getAllMonHoc();

    MonHoc saveMonHoc(MonHoc mh);

    MonHoc getMonHocById(Long id);

    MonHoc updateMonHoc(MonHoc mh);

    void deleteMonHoc(Long id);
}
