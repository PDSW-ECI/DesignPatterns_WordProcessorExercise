/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.wordprocessor.langproc.typos;

import java.util.LinkedHashMap;

/**
 *
 * @author hcadavid
 */
public class EnglishTyposDataSource {

	final static LinkedHashMap<String,String> equivalencesMap;
        
        static{		
		equivalencesMap=new LinkedHashMap<>();		
		
		equivalencesMap.put("helo", "hello");
		equivalencesMap.put("ello", "hello");
		equivalencesMap.put("abd", "and");
		equivalencesMap.put("abcess", "abscess");
                
				
	}
    
	/**
	 * Obj: Verificar que la palabra ingresada esté sujeta a correcciones, por ejemplo
	 * por un error típico de digitacion identificado.	
	 * @param word
	 * @return
	 */
	public String check(String word){
		String res=equivalencesMap.get(word);
		if (res==null){
			return null;
		}
		else{
			return res;
		}
		
	}
	
	
}
