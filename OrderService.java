public class OrderService {
    private final OrderCalculator calculator;
    private final OrderProcessor processor;
    private final InvoiceGenerator invoiceGenerator;
    private final EmailNotifier emailNotifier;

    public OrderService(OrderCalculator calculator, OrderProcessor processor, 
                        InvoiceGenerator invoiceGenerator, EmailNotifier emailNotifier) {
        this.calculator = calculator;
        this.processor = processor;
        this.invoiceGenerator = invoiceGenerator;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(double price, int quantity, String customerName, 
                             String address, String fileName, String email) {
        double total = calculator.calculateTotal(price, quantity);
        System.out.println("Order total: $" + total);

        processor.placeOrder(customerName, address);
        invoiceGenerator.generateInvoice(fileName);
        emailNotifier.sendEmailNotification(email);
    }
}
