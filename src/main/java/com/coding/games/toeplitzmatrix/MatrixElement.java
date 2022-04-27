package com.coding.games.toeplitzmatrix;

import java.util.function.Predicate;

import lombok.Data;

@Data
public class MatrixElement {
	private int lineIndex;
	private int columnIndex;
	private int value;

	public boolean isEligibleToBeAddedToMatrix(Matrix matrix) {
		Predicate<MatrixElement> MatrixElementPredicate = existingElement -> this.lineIndex == existingElement
				.getLineIndex() && this.columnIndex == existingElement.getColumnIndex();

		return lineIndex <= matrix.getNumberOfLines() && columnIndex <= matrix.getNumberOfColumns()
				&& matrix.getElements().stream().noneMatch(MatrixElementPredicate);
	}
}
