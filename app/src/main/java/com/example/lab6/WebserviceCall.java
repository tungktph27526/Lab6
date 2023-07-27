package com.example.lab6;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebserviceCall {
    private static final String TAG = WebserviceCall.class.getSimpleName();
    public static String callWSThreadSoapPrimitive(String strURL, String
            strSoapAction, SoapObject request) {
        try {
            StringBuffer result;
            SoapSerializationEnvelope envelope = new
                    SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE ht = new HttpTransportSE(strURL,60000);
            ht.debug = true;
            ht.call(strSoapAction, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            result = new StringBuffer(response.toString());
            Log.i("alo 1234", "result: " + result.toString());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
