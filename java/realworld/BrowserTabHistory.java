package realworld;

/**
 * A simple implementation of Back and Forward buttons in a web browser.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Interface defining operations in a browser navigation system.
 */
interface NavigableTab<T> {

  /**
   * Boolean if a back exists
   */
  boolean canGoBack();

  /**
   * Returns the page when user wants to go back.
   */
  Optional<T> back();

  /**
   * List of all back pages, that user can visit
   */
  List<T> allBackPages();

  /**
   * Boolean if a back exists
   */
  boolean canGoForward();

  /**
   * Returns the page when user wants to go forward.
   */
  Optional<T> forward();

  /**
   * List of all forward pages, that user can visit
   */
  List<T> allForwardPages();

  /**
   * When a new link is clicked on a page.
   */
  void linkClicked(T page);

}

/**
 * A simple DoublyLinkedList based implementation of the system. We use String to store the URL of
 * the page, but it would be a different class in real life!
 */
public class BrowserTabHistory<T> implements NavigableTab<T> {

  // Doubly Linked List
  private List<T> pages = new LinkedList<>();

  private int currentPageIndex;
  private T currentPage;

  // We need at least one page to start
  public BrowserTabHistory(T homePage) {
    this.currentPage = homePage;
    pages.add(homePage);
    currentPageIndex = 0;
  }

  @Override
  public boolean canGoBack() {
    return false;
  }

  @Override
  public Optional<T> back() {
    return Optional.empty();
  }

  @Override
  public List<T> allBackPages() {
    return pages.subList(0, currentPageIndex);
  }

  @Override
  public boolean canGoForward() {
    return currentPageIndex != pages.size();
  }

  @Override
  public Optional<T> forward() {
    return Optional.empty();
  }

  @Override
  public List<T> allForwardPages() {
    return pages.subList(currentPageIndex, pages.size() - 1);
  }

  @Override
  public void linkClicked(T page) {

  }
}


class Browser {

  public static void main(String[] args) {

    // Simple implementation with a String to store URL of a page.
    BrowserTabHistory<String> history = new BrowserTabHistory<>("www.google.com");
  }
}