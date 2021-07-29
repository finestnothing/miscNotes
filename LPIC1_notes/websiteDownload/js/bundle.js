const langSelectElement = document.querySelector('#lang-select');
const mobileNavBreakpoint = 1024;

const headerElement = document.querySelector('.header');
let headerHeight = 0;

function updateHeaderHeight() {
  let rect = headerElement.getBoundingClientRect();
  let height = rect.height;

  if (window.innerWidth >= mobileNavBreakpoint) {
    const submenuElement = document.querySelector('.nav__menu.-submenu');
    const submenuRect = submenuElement.getBoundingClientRect();

    height += submenuRect.height;
  }

  headerHeight = height;
  return height;
}

updateHeaderHeight();

function getLocale() {
  const path = window.location.pathname;
  let end = path.indexOf('/', 1);
  return path.substr(1, end-1);
}

let locale = getLocale();

function getElementOffset(element) {
  const rect = element.getBoundingClientRect();
  return {
    left: rect.left + window.scrollX,
    top: rect.top + window.scrollY
  };
}

if (langSelectElement) {
  const location = window.location;

  langSelectElement.addEventListener('change', function(e) {
    location.href = location.href.replace(locale, e.target.value);
  });
}

const navElement = document.querySelector('.nav');

if (navElement) {
  const navItemsWithSubmenu = navElement.querySelectorAll('.nav__item.-has-submenu');
  const activeNavItem = navElement.querySelector('.nav__item.-is-active');
  const navButton = navElement.querySelector('.nav__button');
  const submenuToggles = navElement.querySelectorAll('.nav__submenu-toggle');

  navItemsWithSubmenu.forEach(item => {
    if (activeNavItem !== item) {
      item.addEventListener('mouseover', function() {
        if (activeNavItem) {
          activeNavItem.classList.add('hide-arrow');
        }
      });
      item.addEventListener('mouseout', function() {
        if (activeNavItem) {
          activeNavItem.classList.remove('hide-arrow');
        }
      });
    }
  });

  navButton.addEventListener('click', function(e) {
    e.preventDefault();
    document.body.classList.toggle('-nav-open');
  });
}

// general buttons, focusable elements that should not get an
// outline when clicking on them, but when navigating with keyboard
document.querySelectorAll('a, button').forEach(element => {
  element.addEventListener('click', () => {
    element.blur();
  })
});

// History go back buttons
document.querySelectorAll('.js-back').forEach(button => {
  button.addEventListener('click', () => {
    window.history.back();
  });
});



//
// hierarchy
//
const topLinks = document.querySelectorAll('dd.hierarchy__item > .hierarchy__link');
topLinks.forEach(topLink => {
  topLink.innerHTML = topLink.innerHTML.replace(/[0-9]+\.[0-9]+/, '$&\t');
  topLink.classList.add('-initialized');
});




//
// learning materials slider
//
const lmSliderElement = document.querySelector('#lm-slider');

if (lmSliderElement) {
  const lmSliderContainer = lmSliderElement.querySelector('.swiper-container');
  const lmSliderNext = lmSliderElement.querySelector('.swiper-button-next');
  const lmSliderPrev = lmSliderElement.querySelector('.swiper-button-prev');

  if (lmSliderContainer && lmSliderNext && lmSliderPrev) {
    const slidesCount = lmSliderContainer.firstElementChild.childElementCount;

    if (slidesCount <= 4) {
      lmSliderElement.classList.add('-exact');
    }

    const lmSlider = new Swiper(lmSliderContainer, {
      slidesPerView: 'auto',
      slidesPerGroup: 1,
      simulateTouch: true,
      spaceBetween: 24,
      navigation: {
        nextEl: lmSliderNext,
        prevEl: lmSliderPrev
      },
      breakpoints: {
        500: {
          slidesOffsetAfter: 24
        },
        768: {
          slidesOffsetAfter: 0
        }
      }
    });
  }
}

;
const hierarchySectionElements = document.querySelectorAll('.hierarchy__section');

hierarchySectionElements.forEach(function(element) {
  const hierarchyToggle = element.querySelector('.hierarchy__toggle-button');

  if (hierarchyToggle) {
    hierarchyToggle.addEventListener('click', function(event) {
      event.preventDefault();
      element.classList.toggle('-is-active');
    });
  }
});

// progress bar
const lessonContentElement = document.querySelector('.lesson__content');
const progressWrapElement = document.querySelector('.lesson-progress');
const progressElement = document.querySelector('.lesson-progress__current');

if (lessonContentElement && progressWrapElement) {
  const lessonContentRect = lessonContentElement.getBoundingClientRect();
  const lessonContentStart = lessonContentRect.top;
  const lessonContentHeight = lessonContentRect.height;
  const lessonContentEnd = lessonContentStart + lessonContentHeight;

  setTopOffset();
  handleProgressVisbility(headerHeight);
  setProgress(lessonContentHeight);

  function handleProgressVisbility(offset) {
    if (window.scrollY >= offset) {
      progressWrapElement.classList.add('-active');
    } else {
      progressWrapElement.classList.remove('-active');
    }
  }

  function setProgress(readingHeight) {
    const start = getElementOffset(lessonContentElement).top;
    const end = start + readingHeight;
    const relative = (window.scrollY - start) / end;
    progressElement.setAttribute('style', 'transform: scaleX(' + relative + ')')
  }

  function setTopOffset() {
    progressWrapElement.style.top = headerHeight + 'px';
  }

  window.addEventListener('resize', function(event) {
    window.setTimeout(function() {
      updateHeaderHeight();
      setTopOffset();
    }, 200);
  });

  window.addEventListener('scroll', function(event) {
    handleProgressVisbility(headerHeight);
    setProgress(lessonContentHeight);
  });
}
