package com.march.ticketjdbc.model;

public class JsonModule {
	public interface DefaultModule {}
	public interface GetMovieListModule extends DefaultModule {}
	public interface GetCinemaListModule extends DefaultModule {}
	public interface GetSessionListModule extends DefaultModule {}
	public interface GetSessionInfoModule extends DefaultModule {}
	public interface CreateOrderModule extends DefaultModule {}
}
