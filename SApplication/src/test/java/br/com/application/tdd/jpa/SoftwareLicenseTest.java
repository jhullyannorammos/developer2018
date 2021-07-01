package br.com.application.tdd.jpa;

import org.junit.Test;

import br.com.application.domain.SoftwareLicense;
import br.com.application.enumerator.SoftwareEnum;
import br.com.application.persistence.jpa.SoftwareLicensePersistence;

public class SoftwareLicenseTest {
	
	SoftwareLicensePersistence softwareLicensePersistence;
	SoftwareLicense softwareLicense1;
	SoftwareLicense softwareLicense2;
	SoftwareLicense softwareLicense3;
	SoftwareLicense softwareLicense4;
	SoftwareLicense softwareLicense5;
	SoftwareLicense softwareLicense6;
	SoftwareLicense softwareLicense7;
	SoftwareLicense softwareLicense8;
	SoftwareLicense softwareLicense9;
	SoftwareLicense softwareLicense10;
	
	@Test
	public void novo() throws Exception {
		
		softwareLicensePersistence = new SoftwareLicensePersistence();
		
		softwareLicense1 = new SoftwareLicense();
		softwareLicense1.setKey("77777-22222-11111-44444-55555");
		softwareLicense1.setSistema(SoftwareEnum.MICROSFT_WINDOWS_10_PROFESSIONAL_64BITS);
		
		softwareLicense2 = new SoftwareLicense();
		softwareLicense2.setKey("11111-77777-88888-44444-66666");
		softwareLicense2.setSistema(SoftwareEnum.MICROSFT_WINDOWS_7_PROFESSIONAL_64BITS);
		
		softwareLicense3 = new SoftwareLicense();
		softwareLicense3.setKey("77777-22222-99999-55555-55555");
		softwareLicense3.setSistema(SoftwareEnum.MICROSFT_WINDOWS_7_PROFESSIONAL_32BITS);
		
		softwareLicense4 = new SoftwareLicense();
		softwareLicense4.setKey("99999-77777-22222-55555-55555");
		softwareLicense4.setSistema(SoftwareEnum.MICROSFT_WINDOWS_XP_HOME_64BITS);
		
		softwareLicense5 = new SoftwareLicense();
		softwareLicense5.setKey("77777-55555-44444-55555-55555");
		softwareLicense5.setSistema(SoftwareEnum.MICROSFT_WINDOWS_XP_HOME_32BITS);
		
		softwareLicense6 = new SoftwareLicense();
		softwareLicense6.setKey("99999-77777-22222-55555-22222");
		softwareLicense6.setSistema(SoftwareEnum.MICROSFT_WINDOWS_XP_PROFESSIONAL_64BITS);
		
		softwareLicense7 = new SoftwareLicense();
		softwareLicense7.setKey("77777-66666-33333-22222-55555");
		softwareLicense7.setSistema(SoftwareEnum.MICROSFT_WINDOWS_XP_PROFESSIONAL_32BITS);
		
		softwareLicense8 = new SoftwareLicense();
		softwareLicense8.setKey("99999-66666-77777-22222-55555");
		softwareLicense8.setSistema(SoftwareEnum.MICROSOFT_WINDOWS_SERVER_2008_R2_64BITS);
		
		softwareLicense9 = new SoftwareLicense();
		softwareLicense9.setKey("99999-66666-77777-22222-11111");
		softwareLicense9.setSistema(SoftwareEnum.MICROSOFT_WINDOWS_SERVER_2012_R2_64BITS);
		
		softwareLicense10 = new SoftwareLicense();
		softwareLicense10.setKey("99999-66666-33333-55555-22222");
		softwareLicense10.setSistema(SoftwareEnum.MICROSFT_WINDOWS_10_PROFESSIONAL_64BITS);
		
		softwareLicensePersistence.save(softwareLicense1);
		softwareLicensePersistence.save(softwareLicense2);
		softwareLicensePersistence.save(softwareLicense3);
		softwareLicensePersistence.save(softwareLicense4);
		softwareLicensePersistence.save(softwareLicense5);
		softwareLicensePersistence.save(softwareLicense6);
		softwareLicensePersistence.save(softwareLicense7);
		softwareLicensePersistence.save(softwareLicense8);
		softwareLicensePersistence.save(softwareLicense9);
		softwareLicensePersistence.save(softwareLicense10);
		
	}

}
