package sample.cache;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "nfeCache")
public class NFERepository {
	
	private static final Logger logger = LoggerFactory.getLogger(NFERepository.class);

	@Cacheable(value = "nfeCache", key = "#numero")
	public NFE findByNumero(long numero) {
		NFE nfe = new NFE(numero, UUID.randomUUID().toString(), new Date());
		logger.info("ADD CACHE: " + nfe);
		return nfe;
	}

}
