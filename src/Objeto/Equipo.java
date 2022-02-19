package Objeto;

public class Equipo implements Comparable<Equipo> {

    public String equipo; // nombre del equipo
    public int pj; // partidos jugados
    public int pg; // partidos ganados
    public int pe; // partidos empatados
    public int pp; // partidos perdidos
    public int gf; // goles a favor
    public int gc; // goles en contra
    public int dfg; // diferencia de goles
    public int pts; // puntos totales

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
