---
layout: home
dates: Feb 19-21 2020
registration:
  text: REGISTER HERE
  status: enabled
  link:
branding:
  img: /assets/img/dev-nexus-logo-large.png
  alt: Devnexus
---

{% if site.cfp-is-open %}
  <div class="featured-header">
    <h1 class="top-intro"><a href="/call-for-papers">Call For Papers Is Open</a></h1>
  </div>
{% endif %}

{% include {{ site.active-header }} %}

{% include marketing-video.html %}

{% include workshops_promo.html %} 

<div class="row">
<a name="sponsorlist"></a>
      <div class="featured-header">
        <a class="action-header" href="https://ajug.typeform.com/to/BTa7bZ">Interested in Sponsoring Devnexus 2020?</a>
      </div>
{% include sponsor-listing.md rendering="sponsor-thumb.html" %}
</div>
<div>
<a name="timeline"></a>
{% include timeline.html %}
</div>

