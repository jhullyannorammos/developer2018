package br.com.application.enumerator;

public enum SoftwareEnum {

	MICROSOFT_WINDOWS_SERVER_2008_R2_64BITS, 
	MICROSOFT_WINDOWS_SERVER_2012_R2_64BITS,
	MICROSFT_WINDOWS_XP_PROFESSIONAL_64BITS, 
	MICROSFT_WINDOWS_XP_PROFESSIONAL_32BITS,
	MICROSFT_WINDOWS_10_PROFESSIONAL_64BITS,
	MICROSFT_WINDOWS_XP_HOME_64BITS, 
	MICROSFT_WINDOWS_XP_HOME_32BITS, 
	MICROSFT_WINDOWS_7_PROFESSIONAL_64BITS,
	MICROSFT_WINDOWS_7_PROFESSIONAL_32BITS;
	
	public static SoftwareEnum getSoftwareEnum(String s) {
		for(SoftwareEnum software :SoftwareEnum.values()) {
			if(software.toString().equals(s.toUpperCase())) {
				return software;
			}
		}
		return null;
	}

	public String getDescricao() {
		switch (this) {
		      case MICROSOFT_WINDOWS_SERVER_2012_R2_64BITS: return "MICROSOFT WINDOWS SERVER 2012 R2 64BITS";
		      case MICROSOFT_WINDOWS_SERVER_2008_R2_64BITS: return "MICROSOFT WINDOWS SERVER 2008 R2 64BITS";
		      case MICROSFT_WINDOWS_XP_PROFESSIONAL_64BITS: return "MICROSFT WINDOWS XP PROFESSIONAL 64BITS";
		      case MICROSFT_WINDOWS_XP_PROFESSIONAL_32BITS: return "MICROSFT WINDOWS XP PROFESSIONAL 32BITS";
		      case MICROSFT_WINDOWS_10_PROFESSIONAL_64BITS: return "MICROSFT WINDOWS 10 PROFESSIONAL 64BITS";
		      case MICROSFT_WINDOWS_7_PROFESSIONAL_64BITS: return "MICROSFT WINDOWS 7 PROFESSIONAL 64BITS";
		      case MICROSFT_WINDOWS_7_PROFESSIONAL_32BITS: return "MICROSFT WINDOWS 7 PROFESSIONAL 32BITS";
		      case MICROSFT_WINDOWS_XP_HOME_64BITS: return "MICROSFT WINDOWS XP HOME 64BITS";
		      case MICROSFT_WINDOWS_XP_HOME_32BITS: return "MICROSFT WINDOWS XP HOME 32BITS";
		      default: return "";
		}
	}

}
