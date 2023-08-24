package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repositoryI;
	private final MusicoRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		InstrumentoRepository repositoryI, 
		MusicoRepository repositoryM,
		BandaRepository repositoryB,
		IntegranteRepository repositoryN
		) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repositoryI.save(new Instrumento("Guitarra", "Cuerda", "de madera, con caja de resonancia, 6 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Ukelele","Cuerda","de madera, con caja de resonancia pequeña, 4 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Melódica","Viento","teclado pequeño de 2 octavas, sonorizado por soplido"));
		
		Instrumento iVoz= new Instrumento("Voz", "Viento", ".");
		this.repositoryI.save(iVoz);
		Instrumento iGuitarraElectrica = new Instrumento("Guitarra Electrica","Electronico",".");
		this.repositoryI.save(iGuitarraElectrica);
		
		this.repositoryI.save(new Instrumento("Bateria","Percusion","harta bulla"));
		this.repositoryM.save(new Musico("Daniel F"));

		Musico mFredy =new Musico("freddy");
		this.repositoryM.save(mFredy);
		Musico mBrian = new Musico ("Bryan");
		this.repositoryM.save(mBrian);

		Banda bQueen=new Banda("Queen");
		this.repositoryB.save(bQueen);
		this.repositoryN.save(new Integrante(bQueen,mFredy,iVoz));
		this.repositoryN.save(new Integrante(bQueen,mBrian,iGuitarraElectrica));
	}
}