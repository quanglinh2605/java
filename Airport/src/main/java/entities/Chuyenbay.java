package entities;
// Generated Dec 9, 2019, 1:50:24 AM by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Chuyenbay generated by hbm2java
 */
@Entity
@Table(name = "chuyenbay")
public class Chuyenbay implements java.io.Serializable {

	private Integer macb;
	private Sanbay sanbayByMasbden;
	private Sanbay sanbayByMasbdi;
	private String tencb;
	private Date ngaydi;
	private int gheloai1;
	private double giagheloai1;
	private int gheloai2;
	private double giagheloai2;
	private Set<Ve> ves = new HashSet<Ve>(0);
	private Set<Chitietchuyenbay> chitietchuyenbays = new HashSet<Chitietchuyenbay>(0);

	public Chuyenbay() {
	}

	public Chuyenbay(Integer macb) {
		super();
		this.macb = macb;
	}

	public Chuyenbay(Sanbay sanbayByMasbden, Sanbay sanbayByMasbdi, String tencb, Date ngaydi, int gheloai1,
			double giagheloai1, int gheloai2, double giagheloai2) {
		this.sanbayByMasbden = sanbayByMasbden;
		this.sanbayByMasbdi = sanbayByMasbdi;
		this.tencb = tencb;
		this.ngaydi = ngaydi;
		this.gheloai1 = gheloai1;
		this.giagheloai1 = giagheloai1;
		this.gheloai2 = gheloai2;
		this.giagheloai2 = giagheloai2;
	}

	public Chuyenbay(Sanbay sanbayByMasbden, Sanbay sanbayByMasbdi, String tencb, Date ngaydi, int gheloai1,
			double giagheloai1, int gheloai2, double giagheloai2, Set<Ve> ves,
			Set<Chitietchuyenbay> chitietchuyenbays) {
		this.sanbayByMasbden = sanbayByMasbden;
		this.sanbayByMasbdi = sanbayByMasbdi;
		this.tencb = tencb;
		this.ngaydi = ngaydi;
		this.gheloai1 = gheloai1;
		this.giagheloai1 = giagheloai1;
		this.gheloai2 = gheloai2;
		this.giagheloai2 = giagheloai2;
		this.ves = ves;
		this.chitietchuyenbays = chitietchuyenbays;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "macb", unique = true, nullable = false)
	public Integer getMacb() {
		return this.macb;
	}

	public void setMacb(Integer macb) {
		this.macb = macb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "masbden", nullable = false)
	public Sanbay getSanbayByMasbden() {
		return this.sanbayByMasbden;
	}

	public void setSanbayByMasbden(Sanbay sanbayByMasbden) {
		this.sanbayByMasbden = sanbayByMasbden;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "masbdi", nullable = false)
	public Sanbay getSanbayByMasbdi() {
		return this.sanbayByMasbdi;
	}

	public void setSanbayByMasbdi(Sanbay sanbayByMasbdi) {
		this.sanbayByMasbdi = sanbayByMasbdi;
	}

	@Column(name = "tencb", nullable = false, length = 250)
	public String getTencb() {
		return this.tencb;
	}

	public void setTencb(String tencb) {
		this.tencb = tencb;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ngaydi", nullable = false, length = 10)
	public Date getNgaydi() {
		return this.ngaydi;
	}

	public void setNgaydi(Date ngaydi) {
		this.ngaydi = ngaydi;
	}

	@Column(name = "gheloai1", nullable = false)
	public int getGheloai1() {
		return this.gheloai1;
	}

	public void setGheloai1(int gheloai1) {
		this.gheloai1 = gheloai1;
	}

	@Column(name = "giagheloai1", nullable = false, precision = 22, scale = 0)
	public double getGiagheloai1() {
		return this.giagheloai1;
	}

	public void setGiagheloai1(double giagheloai1) {
		this.giagheloai1 = giagheloai1;
	}

	@Column(name = "gheloai2", nullable = false)
	public int getGheloai2() {
		return this.gheloai2;
	}

	public void setGheloai2(int gheloai2) {
		this.gheloai2 = gheloai2;
	}

	@Column(name = "giagheloai2", nullable = false, precision = 22, scale = 0)
	public double getGiagheloai2() {
		return this.giagheloai2;
	}

	public void setGiagheloai2(double giagheloai2) {
		this.giagheloai2 = giagheloai2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chuyenbay")
	public Set<Ve> getVes() {
		return this.ves;
	}

	public void setVes(Set<Ve> ves) {
		this.ves = ves;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chuyenbay")
	public Set<Chitietchuyenbay> getChitietchuyenbays() {
		return this.chitietchuyenbays;
	}

	public void setChitietchuyenbays(Set<Chitietchuyenbay> chitietchuyenbays) {
		this.chitietchuyenbays = chitietchuyenbays;
	}

}
