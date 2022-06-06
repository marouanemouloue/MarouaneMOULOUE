package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.Users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MaterielDaoImpl extends GenericDAO<Materiel> implements MaterielDao {
    @Override
    public List<Materiel> findAll() {
        return super.findAll("SELECT * FROM MATERIEL;");
    }

    @Override
    public Materiel findOne(String id) {
        return super.findOne("SELECT * FROM MATERIEL WHERE code=?;", id);
    }

    @Override
    protected MaterielRowMapper getRowMapper() { // template method design pattern
    	
        return new MaterielRowMapper();
    }

	@Override
	public int addOne(Materiel m) {
		// TODO Auto-generated method stub
		return super.addOne("INSERT into MATERIEL (code,name) VALUES (?,?)",m.getCode(),m.getName());
	}

	@Override
	public int deleteOne(String code) {
		// TODO Auto-generated method stub
		return super.deleteOne("delete from MATERIEL where code = ?", code);
	}


	
}
