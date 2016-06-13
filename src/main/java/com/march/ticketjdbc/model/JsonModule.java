package com.march.ticketjdbc.model;

public class JsonModule {
	public interface DefaultModule {}
	public interface GetMovieListModule extends DefaultModule {}
	public interface GetMovieDetailModule extends DefaultModule {}
	public interface GetCinemaListModule extends DefaultModule {}
	public interface GetSessionListModule extends DefaultModule {}
	public interface GetSessionInfoModule extends DefaultModule {}
	public interface CreateOrderModule extends DefaultModule {}
	public interface GetOrderDetailModule extends DefaultModule {}
	public interface GetOrderListModule extends DefaultModule {}
	public interface UserModule extends DefaultModule {}
	public interface UserLoginModule extends DefaultModule {}
	public interface CinemaModule extends DefaultModule {}
}
