

#include "suma.h"


int suma_prog_1(char *host, int f, int g, CLIENT *clnt) {
	int  *result_1;
	dupla  suma_1_arg;

suma_1_arg.a=f;
suma_1_arg.b=g;

	result_1 = suma_1(&suma_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "Error....Ingrese los valores solicitados \n");
	}
	return *result_1;

#ifndef	DEBUG
	clnt = clnt_create (host, SUMA_PROG, SUMA_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */


#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int main (int argc, char *argv[]) {
	char *host;
	int x;
	int y;
	CLIENT *clnt;

	if (argc < 2) {
		printf ("Ingresa la direccion IP \n");
		exit (1);
	}
	printf("------Suma RPC------\n");
	printf("Numero 1: ");
	scanf("%d",&x);
	printf("Numero 2: ");
	scanf("%d",&y);
	host = argv[1];

	clnt = clnt_create (host, SUMA_PROG, SUMA_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
	printf("Total: %d \n",suma_prog_1(host,x,y,clnt) );
clnt_destroy(clnt);
exit (0);
}
