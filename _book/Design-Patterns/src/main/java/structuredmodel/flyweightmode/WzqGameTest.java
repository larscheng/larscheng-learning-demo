package structuredmodel.flyweightmode;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.ArrayList;

/**
 * 描述:
 * 五子棋围棋模拟场景：享元模式
 *
 * @author lars
 * @date 2019/7/8 10:46
 */
public class WzqGameTest {

    /**
     * 非享元
     */
    static class DownPoint {
        public String Pointxy;

        public DownPoint(String point) {
            Pointxy = point;
        }

        public String getPoint() {
            return Pointxy;
        }

        public void setPoint(String point) {
            Pointxy = point;
        }
    }

    /**
     * 抽象享元
     */
    interface ChessPieces {
        public void DownPieces(DownPoint point);
    }


    /**
     * 具体享元角色
     */
    static class WhitePieces implements ChessPieces {
        @Override
        public void DownPieces(DownPoint point) {
            System.out.println("白子落在：" + point.getPoint());
        }
    }

    static class BlackPieces implements ChessPieces {
        @Override
        public void DownPieces(DownPoint point) {
            System.out.println("黑子落在：" + point.getPoint());
        }
    }


    /**
     * 享元工厂
     */
    static class WzqFactory {
        private ArrayList<ChessPieces> chessPieces = new ArrayList<ChessPieces>();

        public WzqFactory() {
            ChessPieces chessPieces1 = new WhitePieces();
            chessPieces.add(chessPieces1);
            ChessPieces chessPieces2 = new BlackPieces();
            chessPieces.add(chessPieces2);
        }

        public ChessPieces getChessPieces(String type) {
            if (type.equals("white")) {
                return chessPieces.get(0);
            } else if (type.equals("black")) {
                return chessPieces.get(1);
            } else {
                return null;
            }
        }
    }


    /**
     * 客户角色
     */
    static class Client {
        public Client() {
            WzqFactory factory = new WzqFactory();

            ChessPieces chessPieces1 = factory.getChessPieces("black");
            chessPieces1.DownPieces(new DownPoint("(1,2)"));
            ChessPieces chessPieces2 = factory.getChessPieces("white");
            chessPieces2.DownPieces(new DownPoint("(1,3)"));
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
