package TrafficCapture;

import java.io.IOException;
import java.util.List;

import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.NifSelector;

/**
 * Hello world!
 *
 */
public class Driver 
{
    public static void main( String[] args )
    {
        List<PcapNetworkInterface> devices = getNetworkDevices();
        
        
        for (PcapNetworkInterface p : devices)
        {
        	System.out.println(p + "\n\n");
        }
        
    }
    
    
    static List<PcapNetworkInterface> getNetworkDevices()
    {
    	List<PcapNetworkInterface> allNics = null;
    	

    	try 
    	{
			allNics = Pcaps.findAllDevs();
		} 
    	catch (PcapNativeException e) 
    	{	
			e.printStackTrace();
		}
    		
        	if (allNics == null || allNics.isEmpty())
        		return null;
    		
    	
    	return allNics;
    	
    }
    
}
