package chessGameJava_RTAI2023;

public interface IJeu {
    static boolean PionPremDepla(int x) {
        return false;
    }

    static boolean EstSaPiece(Joueur J, Piece piece) {
        return false;
    }

    static boolean echec(Plateau plateau, Joueur JAdverse, Position PosRoi) {
        return false;
    }

    static boolean echec_math(Plateau plateau, Joueur JAdverse, Position PosRoi) {
        return false;
    }

    static void promotion(Piece piece, Joueur J) {
    }
}
