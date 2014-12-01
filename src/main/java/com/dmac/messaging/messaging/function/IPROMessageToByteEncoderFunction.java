package com.dmac.messaging.messaging.function;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;

import com.ipro.vo.IPROMessage;

/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class IPROMessageToByteEncoderFunction {

	
	public byte[] encode(IPROMessage iproMessage) {
		
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    final DatumWriter<IPROMessage> writer = new ReflectDatumWriter(IPROMessage.class);
		
		try (DataFileWriter<IPROMessage> out = new DataFileWriter(writer)) {
	        out.setCodec(CodecFactory.bzip2Codec()).create(ReflectData.get().getSchema(IPROMessage.class), baos);
	            out.append(iproMessage);
	    }
	    catch (final IOException exception) {
	            final String errorMsg = String.format("Error while encoding IPROMessage to byte[]");
	            System.out.println(exception.getMessage());	            
	    }
	    
		return baos.toByteArray();
	    
	}

}
