public class OrderTest {
    public static void main(String[] args) {
        OrderCalculator calculator = new SimpleOrderCalculator();
        OrderProcessor processor = new OrderPlacer();
        InvoiceGenerator invoiceGenerator = new PDFInvoiceGenerator();
        EmailNotifier emailNotifier = new EmailService();

        OrderService orderService = new OrderService(calculator, processor, invoiceGenerator, emailNotifier);
        orderService.processOrder(10.0, 2, "John Doe", "123 Main St", "order_123.pdf", "johndoe@example.com");
    }
}