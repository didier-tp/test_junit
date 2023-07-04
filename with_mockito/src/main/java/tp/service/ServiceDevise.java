package tp.service;

import tp.exception.NotFoundException;

public interface ServiceDevise {
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) throws NotFoundException ;
	//....
}
