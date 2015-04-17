package alunos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// Código que conecta, através de uma API, no site qualeocep. Com o uso da biblioteca JSoup foi possivel extrair
// os endereços.
public class buscaCep {
	
	String CEP;
	
	
	public buscaCep(String CodigoEP) {
		CEP = CodigoEP;		
	}

	public String getEndereco() throws IOException {

        //***************************************************
        try{

 // É obtido o documento HTML da página do site que contém o CEP pedido
        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
  //Dentro do documento, o objeto "span[]" é selecionado, pois é o que contém o endereço propriamente dito, e retornado.
        Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
        for (Element urlEndereco : urlPesquisa) {
        	return urlEndereco.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
     
        return "Falso";
    }
	
	public String getCidade() throws IOException {

        //***************************************************
        try{
//Funciona de forma análoga ao anterior.
        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(120000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
        for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
        }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return "Falso";
    }
	
	 public String getUF() throws IOException {

	        //***************************************************
	        try{

	        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
	                  .timeout(120000)
	                  .get();
	        Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
	        for (Element urlUF : urlPesquisa) {
	                return urlUF.text();
	        }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return "Falso";
	    }

}
