package com.vacina.api.repository.vacina;

import com.vacina.api.model.Vacina;
import com.vacina.api.repository.filter.VacinaFilter;

import java.util.List;

public interface VacinaRepositoryQuery {

    public List<Vacina> filtrar(VacinaFilter vacinaFilter);
}
