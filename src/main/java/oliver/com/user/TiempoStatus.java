package oliver.com.user;


public enum TiempoStatus {
	
	MINUTO(3),HORA(2),DIA(1);
	
	private  int codigo;

	private TiempoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public static TiempoStatus valueOf(Integer i) {
		if (i == null || i == 0) {
			return null;
		}
		for (TiempoStatus e : TiempoStatus.values()) {
			if (e.getCodigo() == i ) {
				return e;
			}
		}
		return null;
	}
}
