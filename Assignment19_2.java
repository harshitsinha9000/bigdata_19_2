import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

public class Assignment19_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	Configuration conf = HBaseConfiguration.create();
	 HTable table = new HTable(conf,"customer");
	 SingleColumnValueFilter filter = new SingleColumnValueFilter(Bytes.toBytes("details"),Bytes.toBytes("location"),CompareOp.EQUAL,Bytes.toBytes("AUS"));
	  filter.setFilterIfMissing(true);
	  
	  Scan scan = new Scan();
	  scan.setFilter(filter);
	  ResultScanner result = table.getScanner(scan);
	  for(Result res:result)
	  {
		  byte[] val=res.getValue(Bytes.toBytes("details"),Bytes.toBytes("location"));
		  System.out.println("Row-value Found: "+Bytes.toString(val));
	  }
	 
	 
			
	}

}
