package com.coding.games.toeplitzmatrix;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Matrix {

	@Getter
	private List<MatrixElement> elements;

	@Getter
	@Setter
	private int numberOfLines;

	@Getter
	@Setter
	private int numberOfColumns;

	@Setter
	private boolean toeplitzMatrix;

	public void addMatrixElement(MatrixElement element) {
		if (Objects.nonNull(element) && element.isEligibleToBeAddedToMatrix(this)) {
			this.elements.add(element);
		}
	}

	public boolean isToeplitzMatrix() {
		this.toeplitzMatrix = false;
		// TODO: code algorithme here
		return this.toeplitzMatrix;
	}
}