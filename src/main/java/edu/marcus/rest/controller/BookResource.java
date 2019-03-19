package edu.marcus.rest.controller;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import edu.marcus.business.controller.BookController;
import edu.marcus.business.domain.BookBusiness;
import edu.marcus.factory.BookFactory;
import edu.marcus.rest.dto.BookDTO;

@Component
@Path("/book")
public class BookResource {

	private BookController bookController;
	private BookFactory bookFactory;

	public BookResource(BookController bookController, BookFactory bookFactory) {
		this.bookController = bookController;
		this.bookFactory = bookFactory;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Iterable<BookBusiness> books = bookController.getAll();
		Iterable<BookDTO> dtos = bookFactory.transformBusiness(books);
		return Response.ok(dtos).build();
	}

	@GET
	@Path("/{oid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("oid") Long oid) {
		BookBusiness book = bookController.get(oid);
        BookDTO dto = bookFactory.transformBusinessToDTO(book);
        return Response.ok(dto).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(BookDTO dto) {
		BookBusiness savedBook = bookController.add(bookFactory.transformDTO(dto));
		return Response.created(URI.create("/" + savedBook.getOid())).build();
	}

	@PUT
	@Path("/{oid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("oid") Long oid, BookDTO dto) {
		BookBusiness book = bookFactory.transformDTO(dto);
		bookController.update(oid, book);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{oid}")
	public Response delete(@PathParam("oid") Long oid) {
		bookController.delete(oid);
		return Response.ok().build();
	}

}
