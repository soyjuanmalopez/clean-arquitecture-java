package com.d4i.sample.movie.delivery.rest;


import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public record CategoryRest(
	@NotNull String name,
	@NotNull Boolean available) implements Serializable {}
