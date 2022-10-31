package com.vacina.api.repository.vacina;

import com.vacina.api.model.Vacina;
import com.vacina.api.model.Vacina_;
import com.vacina.api.repository.filter.VacinaFilter;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VacinaRepositoryImpl implements VacinaRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Vacina> filtrar(VacinaFilter vacinaFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Vacina> criteria = builder.createQuery(Vacina.class);
        Root<Vacina> root = criteria.from(Vacina.class);

        Predicate[] predicates = criarRestricoes(vacinaFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Vacina> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(VacinaFilter vacinaFilter, CriteriaBuilder builder,
                                        Root<Vacina> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(!ObjectUtils.isEmpty(vacinaFilter.getNomeVacina())) {
            predicates.add(builder.like(
                    builder.lower(root.get(Vacina_.nome_vacina)), "%" + vacinaFilter.getNomeVacina().toLowerCase() + "%"));
        }

        if (vacinaFilter.getFaixaEtaria() != null) {
            predicates.add(builder.like(
                    builder.lower(root.get(Vacina_.faixa_etaria)),"%" + vacinaFilter.getFaixaEtaria().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }


}

