package com.dmac.async.messaging.function;



import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.avro.file.DataFileStream;
import org.apache.avro.io.DatumReader;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;

import com.dmac.async.vo.IPROMessage;


/**
*
*
* @author <a href="mailto:aravindh.chinnasamy@mobax.com">Aravindh Chinnasamy</a>
* @version %I%, %G%
* @since 1.0
*/
public class ByteToIPROMessageDecoderFunction {

	/**
	 * 
	 * @param bytes
	 * @return IPROMessage
	 */
	public IPROMessage decode(byte[] bytes) {
		
		Conditions.checkNotNull (bytes);

		IPROMessage iproMessage = null;
		
		final ByteArrayInputStream   bais        = new ByteArrayInputStream (bytes);
		final DatumReader<IPROMessage> reader    = new ReflectDatumReader<IPROMessage>(ReflectData.get().getSchema(IPROMessage.class));

		try (final DataFileStream<IPROMessage> dfs = new DataFileStream<IPROMessage> (bais, reader);) {
			iproMessage = dfs.next (iproMessage);

		} catch (final IOException exception) {
		    final String errorMsg = String.format ("Error while decoding an instance of IPROMessage from the byte-array.");
            System.out.println(exception.getMessage());
        }
		
		return iproMessage;
	}
}
