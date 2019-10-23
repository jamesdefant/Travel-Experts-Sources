/**
 * Entity class to hold data for 1 row in travelexperts.packages table
 * Course: CMPP-264 - Java
 * Assignment: Workshop 6
 * Author: Salah Hadj Cherif
 * Date: Oct 12 2019
 */


package model;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(PackageAdapter.class)
public class Package {

    private int PackageId;
	private	String PkgName;
	private Date PkgStartDate;	//nullable
	private Date PkgEndDate;	 //nullable
	private String PkgDesc	; //nullable
	private double PkgBasePrice 	;
	private Double	PkgAgencyCommission ; //nullable

	public Package(int packageId, String pkgName, Date pkgStartDate, Date pkgEndDate, String pkgDesc,
				   double pkgBasePrice, Double pkgAgencyCommission) {
		PackageId = packageId;
		PkgName = pkgName;
		PkgStartDate = pkgStartDate;
		PkgEndDate = pkgEndDate;
		PkgDesc = pkgDesc;
		PkgBasePrice = pkgBasePrice;
		PkgAgencyCommission = pkgAgencyCommission;
	}


	public int getPackageId() {
		return PackageId;
	}

	public void setPackageId(int packageId) {
		PackageId = packageId;
	}

	public String getPkgName() {
		return PkgName;
	}

	public void setPkgName(String pkgName) {
		PkgName = pkgName;
	}

	public Date getPkgStartDate() {
		return PkgStartDate;
	}

	public void setPkgStartDate(Date pkgStartDate) {
		PkgStartDate = pkgStartDate;
	}

	public Date getPkgEndDate() {
		return PkgEndDate;
	}

	public void setPkgEndDate(Date pkgEndDate) {
		PkgEndDate = pkgEndDate;
	}

	public String getPkgDesc() {
		return PkgDesc;
	}

	public void setPkgDesc(String pkgDesc) {
		PkgDesc = pkgDesc;
	}

	public double getPkgBasePrice() {
		return PkgBasePrice;
	}

	public void setPkgBasePrice(double pkgBasePrice) {
		PkgBasePrice = pkgBasePrice;
	}

	public Double getPkgAgencyCommission() {
		return PkgAgencyCommission;
	}

	public void setPkgAgencyCommission(Double pkgAgencyCommission) {
		PkgAgencyCommission = pkgAgencyCommission;
	}
	//copy a package
	public void copy(Package pckg)
	{
		PackageId = pckg.PackageId;
		PkgName = pckg.PkgName;
		PkgStartDate = pckg.PkgStartDate;
		PkgEndDate = pckg.PkgEndDate;
		PkgDesc = pckg.PkgDesc;
		PkgBasePrice = pckg.PkgBasePrice;
		PkgAgencyCommission = pckg.PkgAgencyCommission;

	}

	@Override
	public String toString() {
		return "Package{" +
				"PackageId=" + PackageId +
				", PkgName='" + PkgName + '\'' +
				", PkgStartDate=" + PkgStartDate +
				", PkgEndDate=" + PkgEndDate +
				", PkgDesc='" + PkgDesc + '\'' +
				", PkgBasePrice=" + PkgBasePrice +
				", PkgAgencyCommission=" + PkgAgencyCommission +
				'}';
	}


}
