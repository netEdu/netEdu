package com.netEdu.paper.service;

import com.netEdu.entity.Paper;
import com.netEdu.entity.Question;
import com.netEdu.paper.vo.PaperPage;

import java.util.List;

public interface PaperService {

    void add(Paper paper);

    List<Paper> queryPaperListByCriteria(PaperPage paperPage);

    List<Question> queryOnePaper(int id);

    void del(String ids);

    void updatePaper(Paper paper);

}
