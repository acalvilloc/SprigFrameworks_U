package com.bolsadeideas.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	private int numElementosPP;
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas= new ArrayList<PageItem>();
		this.numElementosPP = page.getSize();
		this.totalPaginas= page.getTotalPages();
		this.paginaActual=page.getNumber() + 1;
		int desde, hasta;
		if (totalPaginas<= numElementosPP) {
			desde=1;
			hasta=totalPaginas;
		}else
			if(paginaActual<=numElementosPP/2){
				desde= 1 ;
				hasta = numElementosPP;
			}else if(paginaActual >= totalPaginas - numElementosPP/2){
				desde=totalPaginas-numElementosPP+1;
				hasta=numElementosPP;
			}else
			{
				desde=paginaActual - numElementosPP/2;
				hasta= numElementosPP;
			}
		
		for (int i = 0 ; i<= hasta; i++) {
			paginas.add(new PageItem(desde + i , paginaActual == 	desde));
			
		}	
		
		
		
	}

	public String getUrl() {
		return url;
	}

	public Page<T> getPage() {
		return page;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
