package org.jim.structural.flyweight;


import java.util.HashMap;
import java.util.Map;

/*
记录每个房间当前的棋局情况，我们需要给每个房间都创建一个 ChessBoard 棋局对象。
因为游戏大厅中有成千上万的房间（实际上，百万人同时在线的游戏大厅也有很多），
那保存这么多棋局对象就会消耗大量的内存。有没有什么办法来节省内存呢？
这个时候，享元模式就可以派上用场了。像刚刚的实现方式，在内存中会有大量的相似对象。
这些相似对象的 id、text、color 都是相同的，唯独 positionX、positionY 不同。
实际上，我们可以将棋子的 id、text、color 属性拆分出来，设计成独立的类，并且作为享元供多个棋盘复用。
这样，棋盘只需要记录每个棋子的位置信息就可以了
 */

/*
当一个系统中存在大量重复对象的时候，我们就可以利用享元模式，
将对象设计成享元，在内存中只保留一份实例，供多处代码引用，这样可以减少内存中对象的数量，以起到节省内存的目的。
 */


public class ChessBoard {
    private Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {
        chessPieces.put(1, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(1), 0,0));
        chessPieces.put(1, new ChessPiece(
                ChessPieceUnitFactory.getChessPiece(2), 1,0));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
