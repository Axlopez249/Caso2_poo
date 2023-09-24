package funcionamiento;

public class RegionCalculable {
	private String provincia;
	private String region;
	private int temp;
	private int vel_viento;
	private int lluvia;
	
	public RegionCalculable(String pprovincia, String pregion, int ptemp, int pvel_viento, int plluvia) {
		this.provincia = pprovincia;
		this.region = pregion;
		this.temp = ptemp;
		this.vel_viento = pvel_viento;
		this.lluvia = plluvia;
	}
}
