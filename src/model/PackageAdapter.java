package model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class PackageAdapter extends TypeAdapter<Package> {

	final private DateFormat SIMPLE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); 

	@Override
	public Package read(JsonReader in) throws IOException {

	    int PackageId = 0;
		String PkgName = "";
		Date PkgStartDate = null;	//nullable
		Date PkgEndDate = null;	 //nullable
		String PkgDesc = null; //nullable
		double PkgBasePrice = 0;
		Double PkgAgencyCommission = null; //nullable


		// Read the opening curly-brace
		in.beginObject();

		// Loop through the tokens
		while(in.hasNext()) {

			switch(in.nextName()) {

			case "PackageId":
				PackageId = in.nextInt();
				break;

			case "PkgName":
				PkgName = in.nextString();
				break;

			case "PkgStartDate":
				try {
					if(in.peek() != null) {
						PkgStartDate = SIMPLE_FORMAT.parse(in.nextString());
					}
				} catch(ParseException e) {
					e.printStackTrace();
				}
				break;

			case "PkgEndDate":
				try {
					if(in.peek() != null) {
						PkgEndDate = SIMPLE_FORMAT.parse(in.nextString());
					}
				} catch(ParseException e) {
					e.printStackTrace();
				}
				break;

			case "PkgDesc":
				PkgDesc = in.nextString();
				break;

			case "PkgBasePrice":
				PkgBasePrice = in.nextDouble();
				break;

			case "PkgAgencyCommission":
				PkgAgencyCommission = in.nextDouble();
				break;

			}
		}

		// Read the closing curly-brace
		in.endObject();

		// Create a new object
		Package pkg = new Package(PackageId, PkgName, PkgStartDate,
				PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission);

		// Return the object
		return pkg;
	}

	@Override
	public void write(JsonWriter out, Package pkg) throws IOException {

		// Write an open curly-brace to the JSON
		out.beginObject();
					
		// Write the object to JSON in name:value pairs 
		out.name("PackageId").value(pkg.getPackageId());
		out.name("PkgName").value(pkg.getPkgName());
		
		// Check for nulls
		if(pkg.getPkgStartDate() != null) {

			String date = SIMPLE_FORMAT.format(pkg.getPkgStartDate());
			out.name("PkgStartDate").value(date);
		}
		if(pkg.getPkgEndDate() != null) {

			String date = SIMPLE_FORMAT.format(pkg.getPkgEndDate());
			out.name("PkgEndDate").value(date);
		}
		
		if(pkg.getPkgDesc() != null) {
			out.name("PkgDesc").value(pkg.getPkgDesc());
		}
		
		out.name("PkgBasePrice").value(pkg.getPkgBasePrice());
		
		if(pkg.getPkgAgencyCommission() != null) {
			out.name("PkgAgencyCommission").value(pkg.getPkgAgencyCommission());
		}
			
		// Write a closed curly-brace to the JSON
		out.endObject();
		out.close();	
		
	}

}
