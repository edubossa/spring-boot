/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("app")
class SampleClient {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleClient.class);

	private static final List<String> SAMPLE_COUNTRY_CODES = Arrays.asList("AF", "AX",
			"AL", "DZ", "AS", "AD", "AO", "AI", "AQ", "AG", "AR", "AM", "AW", "AU", "AT",
			"AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BM", "BT", "BO", "BQ",
			"BA", "BW", "BV", "BR", "IO", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CV",
			"KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR",
			"CI", "HR", "CU", "CW", "CY", "CZ", "DK", "DJ", "DM", "DO", "EC", "EG", "SV",
			"GQ", "ER", "EE", "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF", "GA",
			"GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN",
			"GW", "GY", "HT", "HM", "VA", "HN", "HK", "HU", "IS", "IN", "ID", "IR", "IQ",
			"IE", "IM", "IL", "IT", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KP", "KR",
			"KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MK",
			"MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM",
			"MD", "MC", "MN", "ME", "MS", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NC",
			"NZ", "NI", "NE", "NG", "NU", "NF", "MP", "NO", "OM", "PK", "PW", "PS", "PA",
			"PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RE", "RO", "RU", "RW",
			"BL", "SH", "KN", "LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS",
			"SC", "SL", "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES", "LK",
			"SD", "SR", "SJ", "SZ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH", "TL", "TG",
			"TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB", "US",
			"UM", "UY", "UZ", "VU", "VE", "VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW");
	
	private List<NFE> listaNFE = new ArrayList<>();

	private final CountryRepository countryService;
	
	private final NFERepository nfeRepository;

	private final Random random;

	@Autowired
	public SampleClient(CountryRepository countryService, NFERepository nfeRepository) {
		this.countryService = countryService;
		this.nfeRepository = nfeRepository;
		this.random = new Random();
	}
	
	@PostConstruct
	private void init() {
		for (int i = 1; i <= 10; i++) {
			listaNFE.add(new NFE(i, UUID.randomUUID().toString(), new Date()));
		}
	}

	@Scheduled(fixedDelay = 1000*30)
	public void retrieveCountry() {
		String randomCode = SAMPLE_COUNTRY_CODES
				.get(this.random.nextInt(SAMPLE_COUNTRY_CODES.size()));
		logger.info("Looking for country with code '" + randomCode + "'");
		this.countryService.findByCode(randomCode);
	}
	
	@Scheduled(fixedDelay = 1000)
	public void retrieveNFE() {
		NFE nfe = listaNFE.get(this.random.nextInt(listaNFE.size()));
		logger.info("##########################################################");
		logger.info(nfe.toString());
		logger.info("##########################################################");
		/*
		 * OBS: apos armazenado os valores em cache, o metodo findByNumero nao passa
		 * pela classe principal caso seus valores ja tenham sido mantido em cache, 
		 * ou seja se colocarmos em debug a classe principal, ira perceber que nao 
		 * entrara no modo debug caso o numero da NFE esteja cacheado.
		 */
		this.nfeRepository.findByNumero(nfe.getNumero());
	}

}
