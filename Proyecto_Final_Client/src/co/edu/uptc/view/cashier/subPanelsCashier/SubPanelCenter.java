package co.edu.uptc.view.cashier.subPanelsCashier;

import java.awt.CardLayout;

import javax.smartcardio.Card;
import javax.swing.JPanel;

import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.BeveragesPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.BurguersPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.HotDogsPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.MexicanPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.PizzasPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.SaladsPanel;
import co.edu.uptc.view.cashier.subPanelsCashier.categoryPanels.SandwichesPanel;

public class SubPanelCenter extends JPanel{
    private ButtonCategoryPanel buttonCategoryPanel;
    private PizzasPanel pizzasPanel;
    private BurguersPanel burguersPanel;
    private HotDogsPanel hotDogsPanel;
    private SandwichesPanel sandwichesPanel;
    private SaladsPanel saladsPanel;
    private MexicanPanel mexicanPanel;
    private BeveragesPanel  beveragesPanel;
    private CardLayout cardLayout;

    public SubPanelCenter() {
        buttonCategoryPanel = new ButtonCategoryPanel(this);
        pizzasPanel = new PizzasPanel();
        burguersPanel = new BurguersPanel();
        hotDogsPanel = new HotDogsPanel();
        sandwichesPanel = new SandwichesPanel();
        saladsPanel = new SaladsPanel();
        mexicanPanel = new MexicanPanel();
        beveragesPanel = new BeveragesPanel();
        cardLayout = new CardLayout();
        setLayout(new CardLayout());
        initComponents();
    }

    private void initComponents() {
        add(buttonCategoryPanel,"buttonCategoryPanel");
        add(pizzasPanel,"pizzasPanel");
        add(burguersPanel,"burguersPanel");
        add(hotDogsPanel,"hotDogsPanel");
        add(sandwichesPanel,"sandwichesPanel");
        add(saladsPanel,"saladsPanel");
        add(mexicanPanel,"mexicanPanel");
        add(beveragesPanel,"beveragesPanel");
    }

    public void showPanel(String cardLayoutName){
        cardLayout.show(this, cardLayoutName);
        revalidate();
        repaint();
    }

}
