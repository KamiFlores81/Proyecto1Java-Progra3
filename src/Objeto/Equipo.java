package Objeto;

public class Equipo implements Comparable<Equipo> {

	public String equipo;
	public int pj;
	public int pg;
	public int pe;
	public int pp;
	public int gf;
	public int gc;
	public int dfg;
	public int pts;

	public Equipo(String equipo, int pj, int pg, int pe, int pp, int gf, int gc, int dfg, int pts) {
		this.equipo = equipo;
		this.pj = pj;
		this.pg = pg;
		this.pe = pe;
		this.pp = pp;
		this.gf = gf;
		this.gc = gc;
		this.dfg = dfg;
		this.pts = pts;
	}

	@Override
	public int compareTo(Equipo e) {
		Integer a = this.pts;
		Integer b = e.pts;
		if (b.compareTo(a) == 0) {
			Integer x = this.dfg;
			Integer y = e.dfg;
			return y.compareTo(x);
		} else
			return b.compareTo(a);
	}
	
	
}
