package it.polito.tdp.nyc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		this.dao = new NYCDao();
		
	}
	
	public List<String> getAllProviders(){
		return this.dao.getAllProviders();
	}
	
	public void creaGrafo(String provider) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, this.dao.getAllVertici(provider));
		
		for (Adiacenza a : this.dao.getAllAdiacenze(provider)) {
			Graphs.addEdgeWithVertices(this.grafo, a.getP1(), a.getP2(), a.getPeso());
		}
		
	}
		public List<Connessione> doQuartieriAdiacenti(String q) {
		List<Connessione> quartieriAdiacenti = new ArrayList<>();
		
		for (String s : Graphs.neighborListOf(this.grafo, q)) {
			DefaultWeightedEdge e = this.grafo.getEdge(s, q);
			quartieriAdiacenti.add(new Connessione(s, this.grafo.getEdgeWeight(e)));
		}
		Collections.sort(quartieriAdiacenti);
		return quartieriAdiacenti;
	}
	

	public Set<String> getVertici(){
		return this.grafo.vertexSet();
	}
	public Integer nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public Integer nArchi() {
		return this.grafo.edgeSet().size();
	}


}
