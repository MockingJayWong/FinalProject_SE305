package com.march.ticketjdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.march.ticketjdbc.daointerface.TicketDAO;
import com.march.ticketjdbc.model.Ticket;

public class TicketDAOImpl implements TicketDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Ticket> findAll() {
		return jdbcTemplate.query("select * from ticket",
				new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}

	@Override
	public List<Ticket> findByOrder(int orderID) {
		return jdbcTemplate.query("select * from ticket where orderID = ?",
				new BeanPropertyRowMapper<Ticket>(Ticket.class), orderID);
	}

	@Override
	public List<Ticket> findBySession(int sessionID) {
		return jdbcTemplate.query("select * from ticket where sessionID = ?",
				new BeanPropertyRowMapper<Ticket>(Ticket.class), sessionID);
	}

	@Override
	public int insert(final Ticket ticket) {

		KeyHolder  generatedKeyHolder = new GeneratedKeyHolder();   
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st = con.prepareStatement("insert into ticket(orderID, seat, price, sessionID) values(?, ?, ?, ?)", new String[]{"id"});
				st.setInt(1, ticket.getOrderID());
				st.setInt(2, ticket.getSeat());
				st.setFloat(3, ticket.getPrice());
				st.setInt(4, ticket.getSessionID());
				return st;
			}
		},generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
		
	}

	@Override
	public int update(Ticket ticket) {
		return jdbcTemplate.update("update ticket set orderID = ?, seat = ?, price = ?, sessionID = ? where id = ?",
				new Object[] { ticket.getOrderID(), ticket.getSeat(), ticket.getPrice(), ticket.getSessionID(), ticket.getId() });
	}

	@Override
	public int delete(int ticketID) {
		return jdbcTemplate.update("delete from ticket where id = ?", ticketID);
	}

}
