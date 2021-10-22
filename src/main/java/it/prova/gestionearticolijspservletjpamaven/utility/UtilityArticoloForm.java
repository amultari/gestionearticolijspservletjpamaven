package it.prova.gestionearticolijspservletjpamaven.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionearticolijspservletjpamaven.model.Articolo;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityArticoloForm {

	public static Articolo createArticoloFromParams(String codiceInputParam, String descrizioneInputParam,
			String prezzoInputStringParam, String dataArrivoStringParam) {

		Articolo result = new Articolo(codiceInputParam, descrizioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setDataArrivo(parseDateArrivoFromString(dataArrivoStringParam));

		return result;
	}

	public static boolean validateArticoloBean(Articolo articoloToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(articoloToBeValidated.getCodice())
				|| StringUtils.isBlank(articoloToBeValidated.getDescrizione())
				|| articoloToBeValidated.getPrezzo() == null 
				|| articoloToBeValidated.getPrezzo() < 1
				|| articoloToBeValidated.getDataArrivo() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataArrivoStringParam) {
		if (StringUtils.isBlank(dataArrivoStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataArrivoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
