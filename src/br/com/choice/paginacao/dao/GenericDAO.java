package br.com.choice.paginacao.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.choice.paginacao.model.Curso;
import br.com.choice.paginacao.util.HibernateUtil;

public class GenericDAO {
	public void excluir (Object object) throws Exception{
		Session sessao = null;
		Transaction transacao = null;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			
			sessao.delete(object);
			transacao.commit();
		}catch (Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}	
	
	public void salvar (Object object) throws Exception{
		Session sessao = null;
		Transaction transacao = null;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			
			sessao.saveOrUpdate(object);
			transacao.commit();
		}catch (Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> buscarTodos() throws Exception{
		ArrayList<Curso> listaRetorno = new ArrayList<Curso>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Curso.class);
		
		criteria.addOrder (Order.asc("nome"));
		
		listaRetorno = (ArrayList<Curso>) criteria.list();
		
		return listaRetorno;
	}
}
