package tp.dao;

import java.util.List;

import tp.entity.Devise;

public interface DaoDevise {
	Devise findByCode(String code);
	List<Devise> findAll();
	Devise saveOrUpdate(Devise d);
	void deleteByCode(String code);
}
