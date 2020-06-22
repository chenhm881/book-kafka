package com.heiio.bookkafka.serialization;

import com.heiio.bookkafka.model.Article;
import org.apache.avro.data.TimeConversions;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serializer;
import org.omg.IOP.CodecFactory;

import java.io.ByteArrayOutputStream;
import java.util.Map;

//public class ArticleDatumSerializer implements Serializer<Article> {
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//
//    }
//
//    @Override
//    public byte[] serialize(String s, Article article) {
//        SpecificData specificData = new SpecificData(); //用于日期和时间格式的转换
//        specificData.addLogicalTypeConversion(new TimeConversions.DateConversion());
//        specificData.addLogicalTypeConversion(new TimeConversions.TimeConversion());
//        specificData.addLogicalTypeConversion(new TimeConversions.TimestampConversion());
//
//        DatumWriter<Article> datumWriter = new SpecificDatumWriter(this.schema, specificData);
//        byte[] bytes = new byte[0];
//        if (article != null) {
//
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            DataFileWriter<Article> dataFileWriter = new DataFileWriter(datumWriter);
//            dataFileWriter.setCodec(CodecFactory.fromString(this.codecName)).create(this.schema, baos);
//            dataFileWriter.append(data);
//            dataFileWriter.flush();
//            baos.flush();
//            bytes = baos.toByteArray();
//            dataFileWriter.close();
//            baos.close();
//        }
//        return bytes;
//    }
//    @Override
//    public void close() {
//
//    }
//}
