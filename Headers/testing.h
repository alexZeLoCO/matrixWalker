#include <iostream>

/*
Shows an n*m Matrix.
*/
void show (int **M, int n, int m) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      printf("%d ", M[i][j]);
    }
    printf("\n");
  }
  printf("\n");
}

/*
Shows an n*n Matrix.
*/
void show (int **M, int n) {
  show (M, n, n);
}

/*
Fills the matrix of size n*m with f.
*/
void fill (int **M, int n, int m, int f) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      M[i][j] = f;
    }
  }
}

/*
Fills the matrix of size n*n with f.
*/
void fill (int **M, int n, int f) {
  fill(M, n, n, f);
}
